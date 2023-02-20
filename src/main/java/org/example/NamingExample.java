/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.AbstractEventListener;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.NamingEvent;

import java.util.Properties;
import java.util.concurrent.*;

/**
 * Nacos naming example.
 * <p>Add the JVM parameter to run the NamingExample:</p>
 * {@code -DserverAddr=${nacos.server.ip}:${nacos.server.port} -Dnamespace=${namespaceId}}
 *
 * @author nkorange
 */
public class NamingExample {

    public static void main(String[] args) throws NacosException, InterruptedException {

        Properties properties = new Properties();
        properties.setProperty("serverAddr", "host27:8848");
        properties.setProperty("namespace", "itsaas");

        NamingService naming = NamingFactory.createNamingService(properties);

        System.out.println("instances after register: " + naming.getAllInstances("itsm-uc", "ITSM"));

//        naming.registerInstance("nacos.test.3", "11.11.11.11", 8888, "TEST1");
//
//        System.out.println("instances after register: " + naming.getAllInstances("nacos.test.3"));
//
//        Executor executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(),
//                new ThreadFactory() {
//                    @Override
//                    public Thread newThread(Runnable r) {
//                        Thread thread = new Thread(r);
//                        thread.setName("test-thread");
//                        return thread;
//                    }
//                });
//
//        naming.subscribe("nacos.test.3", new AbstractEventListener() {
//
//            //EventListener onEvent is sync to handle, If process too low in onEvent, maybe block other onEvent callback.
//            //So you can override getExecutor() to async handle event.
//            @Override
//            public Executor getExecutor() {
//                return executor;
//            }
//
//            @Override
//            public void onEvent(Event event) {
//                System.out.println("event内容："+JSON.toJSONString(event));
//                System.out.println("serviceName: " + ((NamingEvent) event).getServiceName());
//                System.out.println("instances from event: " + ((NamingEvent) event).getInstances());
//            }
//        });
//        System.out.println("开始休息5秒");
//        Thread.sleep(5000);
//        System.out.println("结束休息5秒");
//        naming.registerInstance("nacos.test.4", "11.11.11.12", 8888, "TEST1");
//        naming.deregisterInstance("nacos.test.3", "11.11.11.11", 8888, "TEST1");
//        naming.deregisterInstance("nacos.test.4", "11.11.11.12", 8888, "TEST1");
//
//        Thread.sleep(1000);
//
//        System.out.println("instances after deregister: " + naming.getAllInstances("nacos.test.3"));
//
//        Thread.sleep(1000);
    }
}
