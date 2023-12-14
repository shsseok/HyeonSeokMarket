package jpabook.jpashop.api;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
public class MemeberApiController {
    private final MemberService memberService;

    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest requests)
    {
        Member member=new Member();
        member.setName(requests.getName());
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }
            @Data
            static class CreateMemberRequest
            {
                @NotEmpty
                private String name;
                public CreateMemberRequest()
                {

                }

            }
            @Data
            static class CreateMemberResponse
            {
                private Long id;
                public CreateMemberResponse(Long id)
                {
                    this.id=id;
                }

            }

}
