package com.leibniz.server.dao.impl;

import com.leibniz.server.dao.itf.AbstractDao;
import com.leibniz.server.dao.itf.IGenericDao;
import com.leibniz.server.repositories.ClientRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public class ClientDao extends AbstractDao<ClientRepository>
        implements IGenericDao<ClientRepository> {
}
