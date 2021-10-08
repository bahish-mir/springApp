package lab.assist.specifications;

import lab.assist.model.Car;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CarSpecification extends CriteriaCarModel implements Specification<Car> {
    public static final String ID = "id";
    public static final String MODEL = "model";
    public static final String COLOR = "color";
    public static final String PERSON_ID = "personId";

    @Override
    public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        var predicates = new ArrayList<Predicate>();
        if (this.model != null)
            predicates.add(builder.equal(root.get(MODEL), model));
        if (this.color != null)
            predicates.add(builder.equal(root.get(COLOR), color));
        if (this.id != null)
            predicates.add(builder.equal(root.get(ID), id));
        if (this.personId != null)
            predicates.add(builder.equal(root.get(PERSON_ID), personId));

        return andTogether(predicates, builder);
    }

    private static Predicate andTogether(List<Predicate> predicates, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
