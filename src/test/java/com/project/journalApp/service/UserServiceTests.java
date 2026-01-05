package com.project.journalApp.service;

import com.project.journalApp.Repository.UserRepository;
import com.project.journalApp.entity.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void testAdd(){//Example
        assertEquals(4,2+2);
        assertTrue(5 >3);
    }


    @Test
    public void findByUserName(){
//        assertNotNull(userRepository.findByUserName("suchi"));
        User user = userRepository.findByUserName("suchi");
        assertTrue(!user.getJournalEntries().isEmpty());
    }



    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,2,4",
            "3,3,7"
    })
    public void test(int a,int b,int expected){
        assertEquals(expected,a+b);
    }


    @ParameterizedTest
    @ValueSource(strings= {
            "ram",
            "suchi",
            "triveni",
            "vipul"
    })
    public void findByUserName(String name){
        assertNotNull(userRepository.findByUserName(name),"failed for: "+name);
    }
}
