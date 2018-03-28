package com.leibniz.server;

import com.leibniz.server.dao.impl.ClientDao;
import com.leibniz.server.dao.itf.AbstractDao;
import com.leibniz.server.dao.itf.IClientDao;
import com.leibniz.server.dao.itf.IGenericDao;
import com.leibniz.server.repositories.ClientRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@EnableJpaRepositories(basePackageClasses = {IClientDao.class, ClientDao.class})
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ComponentScan(basePackageClasses = ClientDao.class)
public class ClientDaoTest {

    @Autowired
    private IClientDao clientDao;

//    @Autowired
//    public void setDao(IGenericDao<ClientRepository> daoToSet ){
//        clientDao = (IClientDao) daoToSet;
//        clientDao.setEntity(ClientRepository.class );
//    }

    @Before
    public void setUp() {
        System.out.println("Hallo Welt !");
        ClientRepository client = new ClientRepository();
        client.setGender(1);
        client.setName("joecedrick");
        client.setPhone("+2370152 487 32");

        clientDao.create(client);

    }

    @Test
    public void findAllTest() {
        System.out.println("Find All Test Method ");
        List<ClientRepository> listOfClient = clientDao.findAll();
        Assert.assertNotNull("the Collection have to be empty", listOfClient);
//        Assert.assertEquals("Name does not match", listOfClient);
    }
}
