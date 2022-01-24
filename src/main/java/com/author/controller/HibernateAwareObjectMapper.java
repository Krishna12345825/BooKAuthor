package com.author.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.hibernate.Hibernate;






public class HibernateAwareObjectMapper extends ObjectMapper {

    private  static  final  long serialVersionUID = 1L;
    public  HibernateAwareObjectMapper(){

        Hibernate5Module module=new Hibernate5Module();
        module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
        registerModule(module);
    }

}

