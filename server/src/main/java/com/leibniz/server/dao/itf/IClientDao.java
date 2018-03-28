package com.leibniz.server.dao.itf;

import com.leibniz.server.repositories.ClientRepository;


public interface IClientDao extends IGenericDao<ClientRepository> {
    void setEntity(Class<ClientRepository> clientRepositoryClass);
}
