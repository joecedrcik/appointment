package com.leibniz.server.dao.impl;

import com.leibniz.server.dao.itf.AbstractDao;
import com.leibniz.server.dao.itf.IClientDao;
import com.leibniz.server.repositories.ClientRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public class ClientDao extends AbstractDao<ClientRepository> implements IClientDao {

}
