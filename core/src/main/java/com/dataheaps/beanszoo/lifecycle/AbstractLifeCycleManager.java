package com.dataheaps.beanszoo.lifecycle;

import com.dataheaps.beanszoo.rpc.RpcFactory;
import com.dataheaps.beanszoo.sd.ServiceDirectoryFactory;
import com.dataheaps.beanszoo.utils.ContainerUtils;

import lombok.AllArgsConstructor;

/**
 * Created by admin on 8/2/17.
 * @author number9code
 */

@AllArgsConstructor
public abstract class AbstractLifeCycleManager {

    final Configuration config;

    public abstract void start() throws Exception;
    public abstract void stop() throws Exception;

    protected void runCommands(Container c, ContainerConfiguration cf) throws Exception {
        for (Command cmd: cf.getCommands()) {
            cmd.run(c.services);
        }
    }

    Container createContainer(ContainerConfiguration containerConfig, RoleConfiguration[] roles, RpcFactory rpcFactory, ServiceDirectoryFactory sdFactory) throws Exception {
        Container c = new ContainerUtils().createContainer(containerConfig, roles, rpcFactory, sdFactory);
        return c;
    }

}
