package com.jlundhoo.goalsky.models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GoalEO.class)
public abstract class GoalEO_ {

	public static volatile SingularAttribute<GoalEO, Integer> goalID;
	public static volatile SingularAttribute<GoalEO, String> title;
	public static volatile SingularAttribute<GoalEO, Date> creationDate;
	public static volatile SingularAttribute<GoalEO, Integer> userID;

}

