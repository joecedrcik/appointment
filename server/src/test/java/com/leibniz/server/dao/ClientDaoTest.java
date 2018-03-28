package com.leibniz.server.dao;

import com.leibniz.server.Application;
import com.leibniz.server.dao.impl.ClientDao;
import com.leibniz.server.dao.itf.IClientDao;
import com.leibniz.server.datasource.DbConfig;
import com.leibniz.server.repositories.ClientRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class, DbConfig.class})
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ClientDaoTest {

    @Autowired(required=true)
    private IClientDao clientDao;

    @Before
    public void setUp() {
//        ClientRepository client = new ClientRepository();
//        client.setGender(1);
//        client.setName("joecedrick");
//        client.setPhone("+2370152 487 32");
//
//        clientDao.create(client);

    }

    @Test
    public void findAllTest() {
        List<ClientRepository> listOfClient = clientDao.findAll();
        Assert.assertNotNull("the Collection have to be empty", listOfClient);
        Assert.assertEquals("Name does not match", "joecedrick",listOfClient.get(0).getName());

    }
}
