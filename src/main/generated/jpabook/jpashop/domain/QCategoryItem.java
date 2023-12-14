package jpabook.jpashop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategoryItem is a Querydsl query type for CategoryItem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategoryItem extends EntityPathBase<CategoryItem> {

    private static final long serialVersionUID = -1009696652L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCategoryItem categoryItem1 = new QCategoryItem("categoryItem1");

    public final QCategoryItem categoryItem;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final jpabook.jpashop.domain.item.QItem item;

    public QCategoryItem(String variable) {
        this(CategoryItem.class, forVariable(variable), INITS);
    }

    public QCategoryItem(Path<? extends CategoryItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCategoryItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCategoryItem(PathMetadata metadata, PathInits inits) {
        this(CategoryItem.class, metadata, inits);
    }

    public QCategoryItem(Class<? extends CategoryItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.categoryItem = inits.isInitialized("categoryItem") ? new QCategoryItem(forProperty("categoryItem"), inits.get("categoryItem")) : null;
        this.item = inits.isInitialized("item") ? new jpabook.jpashop.domain.item.QItem(forProperty("item")) : null;
    }

}

