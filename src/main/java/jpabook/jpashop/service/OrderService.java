package jpabook.jpashop.service;


import jpabook.jpashop.domain.Delivery;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.exception.NoItemException;
import jpabook.jpashop.exception.NoUserException;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.dto.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class  OrderService {
    private  final OrderRepository orderRepository;
    private  final MemberRepository memberRepository;
    private  final ItemRepository itemRepository;
    //주문
    @Transactional
    public Long order(Long memberId,Long itemId, int count)
    {
        //엔티티 조회 //Optional을 반환 받아서 orElseThrow를 통해 값이 없을 때 예외를 터트림ㄴ
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()-> new NoUserException("해당 Id에 대한 유저가 없습니다"));
        Item item= itemRepository.findById(itemId)
                .orElseThrow(() -> new NoItemException("해당 하는 상품이 없습니다."));
        //배송 정보 생성
        Delivery delivery= new Delivery();
        delivery.setAddress(member.getAddress());

        //주문 상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item,item.getPrice(),count);

        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();

    }
    //취소
    @Transactional
    public void cancelOrder(Long orderId)
    {
        Order order = orderRepository.findOne(orderId);
        order.cancel();
    }
    //검색
    public List<Order> findOrders(OrderSearch orderSearch)
    {
        return orderRepository.findAllByString(orderSearch);
    }


}
