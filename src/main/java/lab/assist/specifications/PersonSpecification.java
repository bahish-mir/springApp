package lab.assist.specifications;

import lab.assist.model.Person;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PersonSpecification extends CriteriaPersonModel implements Specification<Person> {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";

    @Override
    public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        if(this.id != null)
            predicates.add(builder.equal(root.get(ID), id));
        if(this.name != null)
            predicates.add(builder.equal(root.get(NAME), name));
        if(this.email != null)
            predicates.add(builder.equal(root.get(EMAIL), email));

        return andTogether(predicates, builder);
    }

    private static Predicate andTogether(List<Predicate> predicates, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
