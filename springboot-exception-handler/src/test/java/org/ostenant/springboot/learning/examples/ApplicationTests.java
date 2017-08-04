package org.ostenant.springboot.learning.examples;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ostenant.springboot.learning.examples.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@WebAppConfiguration
@Slf4j(topic = "UserTester")
public class ApplicationTests {

    private static boolean singleRunner = false;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private MockHttpSession session;

    @Autowired
    private UserController userController;

    private ImmutableMap<Long, Pair<String, String>> map = new ImmutableMap.Builder<Long, Pair<String, String>>()
            .put(0x00001L, Pair.of("user", ""))
            .put(0x00002L, Pair.of("user", "{}"))
            .put(0x00003L, Pair.of("user", "{\"username\": \"\", \"accountName\": \"\"}"))
            .put(0x00004L, Pair.of("user", "{\"username\": \"Madison\", \"accountName\": \"\"}"))
            .put(0x00005L, Pair.of("user", "{\"username\": \"Madison\", \"accountName\": \"Ostenant\"}"))
            .build();


    @Before
    public void setUp() throws Exception {
        if (singleRunner) {
            this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        } else {
            this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        }
        session = new MockHttpSession();
        session.setAttribute("loginId", StringUtils.replace(UUID.randomUUID().toString(), "-", ""));
        log.debug("loginId: {}", session.getAttribute("loginId"));
    }

    /**
     * 测试SessionNotFoundException
     *
     * @throws Exception
     */
    @Test
    public void testSessionNotFoundException() throws Exception {
        session.clearAttributes();
        // 模拟发送请求
        mockMvc.perform(
                MockMvcRequestBuilders.post("/user")
                        .param(map.get(0x00005L).getKey(), map.get(0x00005L).getValue())
                        .session(session))
                .andExpect(MockMvcResultMatchers.handler().handlerType(UserController.class))
                .andExpect(MockMvcResultMatchers.handler().methodName(("save")))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    /**
     * 测试NullOrEmptyException
     *
     * @throws Exception
     */
    @Test
    public void testNullOrEmptyException() throws Exception {
        // 模拟发送请求
        mockMvc.perform(
                MockMvcRequestBuilders.post("/user")
                        .param(map.get(0x00001L).getKey(), map.get(0x00001L).getValue())
                        .session(session))
                .andExpect(MockMvcResultMatchers.handler().handlerType(UserController.class))
                .andExpect(MockMvcResultMatchers.handler().methodName(("save")))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        mockMvc.perform(
                MockMvcRequestBuilders.post("/user")
                        .param(map.get(0x00002L).getKey(), map.get(0x00002L).getValue())
                        .session(session))
                .andExpect(MockMvcResultMatchers.handler().handlerType(UserController.class))
                .andExpect(MockMvcResultMatchers.handler().methodName(("save")))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }

    /**
     * 测试IllegalPropException
     *
     * @throws Exception
     */
    @Test
    public void testIllegalPropException() throws Exception {
        // 模拟发送请求
        mockMvc.perform(
                MockMvcRequestBuilders.post("/user")
                        .param(map.get(0x00003L).getKey(), map.get(0x00003L).getValue())
                        .session(session))
                .andExpect(MockMvcResultMatchers.handler().handlerType(UserController.class))
                .andExpect(MockMvcResultMatchers.handler().methodName(("save")))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        mockMvc.perform(
                MockMvcRequestBuilders.post("/user")
                        .param(map.get(0x00004L).getKey(), map.get(0x00004L).getValue())
                        .session(session))
                .andExpect(MockMvcResultMatchers.handler().handlerType(UserController.class))
                .andExpect(MockMvcResultMatchers.handler().methodName(("save")))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    /**
     * 测试正常情况
     *
     * @throws Exception
     */
    @Test
    public void testNormal() throws Exception {
        // 模拟发送请求
        mockMvc.perform(
                MockMvcRequestBuilders.post("/user")
                        .param(map.get(0x00005L).getKey(), map.get(0x00005L).getValue())
                        .session(session))
                .andExpect(MockMvcResultMatchers.handler().handlerType(UserController.class))
                .andExpect(MockMvcResultMatchers.handler().methodName(("save")))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


}
