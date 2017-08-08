package org.lin.monitor.manager.configurator.connector;

import org.lin.monitor.manager.parser.connector.ConnectorParser;
import org.lin.monitor.manager.parser.connector.HostConfig;
import org.suns.data.collector.config.sheet428.Sheet428CoreConfig;
import org.suns.data.collector.config.sheet428.Sheet428PersonalConfig;

import java.util.ArrayList;

/**
 * Created by guanl on 7/17/2017.
 */
public class DataCollectorSheet428Configurator {
    private ConnectorParser connectorParser;

    public DataCollectorSheet428Configurator(ConnectorParser connectorParser) {
        this.connectorParser = connectorParser;
    }

    public DataCollectorSheet428Configurator() {
        this.connectorParser = null;
    }

    public ConnectorParser getConnectorParser() {
        return connectorParser;
    }

    public void setConnectorParser(ConnectorParser connectorParser) {
        this.connectorParser = connectorParser;
    }

    public void configurePersonal() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        String getTimeCMD = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getTimeCMD();
        Sheet428PersonalConfig.setTimeCmd(getTimeCMD);

        String correctReport = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getCorrectReport();
        Sheet428PersonalConfig.setCorrectReport(correctReport);

        long diffTolerance = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getTimeDiffTolerance();
        Sheet428PersonalConfig.setDiffTolerance(diffTolerance);

        HostConfig timeServer = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getTimeServer();
        String hostTimeServer = timeServer.getIp();
        String[] userTimeServer = {timeServer.getUser()};
        String[] passwordTimeServer = {timeServer.getPassword()};
        int[] portTimeServer = {timeServer.getPort()};
        Sheet428PersonalConfig.setTimeServer(hostTimeServer);
        Sheet428PersonalConfig.setPasswordsTimeServer(passwordTimeServer);
        Sheet428PersonalConfig.setUsersTimeServer(userTimeServer);
        Sheet428PersonalConfig.setPortsTimeServer(portTimeServer);

        ArrayList<HostConfig> hostsConfig1 = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getPersonal().getHosts1();
        int sizeHost1 = hostsConfig1.size();
        String[] hosts1 = new String[sizeHost1];
        String[] users1 = new String[sizeHost1];
        String[] passwords1 = new String[sizeHost1];
        int[] ports1 = new int[sizeHost1];
        copyFromHostConfigArray(hostsConfig1, hosts1, users1, passwords1, ports1);
        Sheet428PersonalConfig.setInspectedHosts1(hosts1);
        Sheet428PersonalConfig.setPasswords1(passwords1);
        Sheet428PersonalConfig.setUsers1(users1);
        Sheet428PersonalConfig.setPasswords1(passwords1);
        Sheet428PersonalConfig.setPorts1(ports1);

        ArrayList<HostConfig> hostsConfig2 = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getPersonal().getHosts2();
        int sizeHost2 = hostsConfig2.size();
        String[] hosts2 = new String[sizeHost2];
        String[] users2 = new String[sizeHost2];
        String[] passwords2 = new String[sizeHost2];
        int[] ports2 = new int[sizeHost2];
        copyFromHostConfigArray(hostsConfig2, hosts2, users2, passwords2, ports2);
        Sheet428PersonalConfig.setInspectedHosts2(hosts2);
        Sheet428PersonalConfig.setPasswords2(passwords2);
        Sheet428PersonalConfig.setUsers2(users2);
        Sheet428PersonalConfig.setPasswords2(passwords2);
        Sheet428PersonalConfig.setPorts2(ports2);

        ArrayList<HostConfig> hostsConfig3 = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getPersonal().getHosts3();
        int sizeHost3 = hostsConfig3.size();
        String[] hosts3 = new String[sizeHost3];
        String[] users3 = new String[sizeHost3];
        String[] passwords3 = new String[sizeHost3];
        int[] ports3 = new int[sizeHost3];
        copyFromHostConfigArray(hostsConfig3, hosts3, users3, passwords3, ports3);
        Sheet428PersonalConfig.setInspectedHosts3(hosts3);
        Sheet428PersonalConfig.setPasswords3(passwords3);
        Sheet428PersonalConfig.setUsers3(users3);
        Sheet428PersonalConfig.setPasswords3(passwords3);
        Sheet428PersonalConfig.setPorts3(ports3);

        ArrayList<HostConfig> hostsConfig4 = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getPersonal().getHosts4();
        int sizeHost4 = hostsConfig4.size();
        String[] hosts4 = new String[sizeHost4];
        String[] users4 = new String[sizeHost4];
        String[] passwords4 = new String[sizeHost4];
        int[] ports4 = new int[sizeHost4];
        copyFromHostConfigArray(hostsConfig4, hosts4, users4, passwords4, ports4);
        Sheet428PersonalConfig.setInspectedHosts4(hosts4);
        Sheet428PersonalConfig.setPasswords4(passwords4);
        Sheet428PersonalConfig.setUsers4(users4);
        Sheet428PersonalConfig.setPasswords4(passwords4);
        Sheet428PersonalConfig.setPorts4(ports4);
    }

    public void configureCore() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        String getTimeCMD = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getTimeCMD();
        Sheet428CoreConfig.setTimeCmd(getTimeCMD);

        String correctReport = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getCorrectReport();
        Sheet428CoreConfig.setCorrectReport(correctReport);

        long diffTolerance = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getTimeDiffTolerance();
        Sheet428CoreConfig.setDiffTolerance(diffTolerance);

        HostConfig timeServer = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getTimeServer();
        String hostTimeServer = timeServer.getIp();
        String[] userTimeServer = {timeServer.getUser()};
        String[] passwordTimeServer = {timeServer.getPassword()};
        int[] portTimeServer = {timeServer.getPort()};
        Sheet428CoreConfig.setTimeServer(hostTimeServer);
        Sheet428CoreConfig.setPasswordsTimeServer(passwordTimeServer);
        Sheet428CoreConfig.setUsersTimeServer(userTimeServer);
        Sheet428CoreConfig.setPortsTimeServer(portTimeServer);

        ArrayList<HostConfig> hostsConfig1 = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getCore().getHosts1();
        int sizeHost1 = hostsConfig1.size();
        String[] hosts1 = new String[sizeHost1];
        String[] users1 = new String[sizeHost1];
        String[] passwords1 = new String[sizeHost1];
        int[] ports1 = new int[sizeHost1];
        copyFromHostConfigArray(hostsConfig1, hosts1, users1, passwords1, ports1);
        Sheet428CoreConfig.setInspectedHosts1(hosts1);
        Sheet428CoreConfig.setPasswords1(passwords1);
        Sheet428CoreConfig.setUsers1(users1);
        Sheet428CoreConfig.setPasswords1(passwords1);
        Sheet428CoreConfig.setPorts1(ports1);

        ArrayList<HostConfig> hostsConfig2 = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getCore().getHosts2();
        int sizeHost2 = hostsConfig2.size();
        String[] hosts2 = new String[sizeHost2];
        String[] users2 = new String[sizeHost2];
        String[] passwords2 = new String[sizeHost2];
        int[] ports2 = new int[sizeHost2];
        copyFromHostConfigArray(hostsConfig2, hosts2, users2, passwords2, ports2);
        Sheet428CoreConfig.setInspectedHosts2(hosts2);
        Sheet428CoreConfig.setPasswords2(passwords2);
        Sheet428CoreConfig.setUsers2(users2);
        Sheet428CoreConfig.setPasswords2(passwords2);
        Sheet428CoreConfig.setPorts2(ports2);

        ArrayList<HostConfig> hostsConfig34 = connectorParser.getHostsInspectionConfig()
                .getSheet428Parser().getCore().getHosts34();
        int sizeHost34 = hostsConfig34.size();
        String[] hosts34 = new String[sizeHost34];
        String[] users34 = new String[sizeHost34];
        String[] passwords34 = new String[sizeHost34];
        int[] ports34 = new int[sizeHost34];
        copyFromHostConfigArray(hostsConfig34, hosts34, users34, passwords34, ports34);
        Sheet428CoreConfig.setInspectedHosts34(hosts34);
        Sheet428CoreConfig.setPasswords34(passwords34);
        Sheet428CoreConfig.setUsers34(users34);
        Sheet428CoreConfig.setPasswords34(passwords34);
        Sheet428CoreConfig.setPorts34(ports34);
    }

    private void copyFromHostConfigArray(ArrayList<HostConfig> hostsConfig
            ,String[] hosts, String[] users
            , String[] passwords, int[] ports){
        int size = hostsConfig.size();

        for(int i=0; i<size; i++){
            hosts[i] = hostsConfig.get(i).getIp();
            users[i] = hostsConfig.get(i).getUser();
            passwords[i] = hostsConfig.get(i).getPassword();
            ports[i] = hostsConfig.get(i).getPort();
        }
    }
}
