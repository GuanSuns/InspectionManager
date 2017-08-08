package org.lin.monitor.manager.configurator.connector;

import org.lin.monitor.manager.parser.connector.ConnectorParser;
import org.lin.monitor.manager.parser.connector.HostConfig;
import org.suns.data.collector.config.sheet412.Sheet421CoreConfig;
import org.suns.data.collector.config.sheet412.Sheet421PersonalConfig;

import java.util.ArrayList;

/**
 * Created by guanl on 7/17/2017.
 */
public class DataCollectorSheet421Configurator {
    private ConnectorParser connectorParser;

    public DataCollectorSheet421Configurator(ConnectorParser connectorParser) {
        this.connectorParser = connectorParser;
    }

    public DataCollectorSheet421Configurator() {
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

        String rootDirectory = connectorParser.getHostsInspectionConfig()
                .getSheet421Parser().getPersonal().getRootDirectory();
        Sheet421PersonalConfig.setRootDirectory(rootDirectory);

        String softwareDirectory = connectorParser.getHostsInspectionConfig()
                .getSheet421Parser().getPersonal().getSoftwareDirectory();
        Sheet421PersonalConfig.setSoftwareDirectory(softwareDirectory);

        String ggsDirectory = connectorParser.getHostsInspectionConfig()
                .getSheet421Parser().getPersonal().getGgsDirectory();
        Sheet421PersonalConfig.setSoftwareGgsDirectory(ggsDirectory);

        ArrayList<HostConfig> hostsConfig2 = connectorParser.getHostsInspectionConfig()
                .getSheet421Parser().getPersonal().getHosts2();
        int sizeHost2 = hostsConfig2.size();
        String[] hosts2 = new String[sizeHost2];
        String[] users2 = new String[sizeHost2];
        String[] passwords2 = new String[sizeHost2];
        int[] ports2 = new int[sizeHost2];
        copyFromHostConfigArray(hostsConfig2, hosts2, users2, passwords2, ports2);
        Sheet421PersonalConfig.setInspectedHosts2(hosts2);
        Sheet421PersonalConfig.setPasswords2(passwords2);
        Sheet421PersonalConfig.setUsers2(users2);
        Sheet421PersonalConfig.setPasswords2(passwords2);
        Sheet421PersonalConfig.setPorts2(ports2);

        ArrayList<HostConfig> hostsConfig3 = connectorParser.getHostsInspectionConfig()
                .getSheet421Parser().getPersonal().getHosts3();
        int sizeHost3 = hostsConfig3.size();
        String[] hosts3 = new String[sizeHost3];
        String[] users3 = new String[sizeHost3];
        String[] passwords3 = new String[sizeHost3];
        int[] ports3 = new int[sizeHost3];
        copyFromHostConfigArray(hostsConfig3, hosts3, users3, passwords3, ports3);
        Sheet421PersonalConfig.setInspectedHosts3(hosts3);
        Sheet421PersonalConfig.setPasswords3(passwords3);
        Sheet421PersonalConfig.setUsers3(users3);
        Sheet421PersonalConfig.setPasswords3(passwords3);
        Sheet421PersonalConfig.setPorts3(ports3);
    }

    public void configureCore() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        String rootDirectory = connectorParser.getHostsInspectionConfig()
                .getSheet421Parser().getCore().getRootDirectory();
        Sheet421CoreConfig.setRootDirectory(rootDirectory);

        String softwareDirectory = connectorParser.getHostsInspectionConfig()
                .getSheet421Parser().getCore().getSoftwareDirectory();
        Sheet421CoreConfig.setSoftwareDirectory(softwareDirectory);

        String ggsDirectory = connectorParser.getHostsInspectionConfig()
                .getSheet421Parser().getPersonal().getGgsDirectory();
        Sheet421CoreConfig.setSoftwareGgsDirectory(ggsDirectory);

        ArrayList<HostConfig> hostsConfig2 = connectorParser.getHostsInspectionConfig()
                .getSheet421Parser().getCore().getHosts2();
        int sizeHost2 = hostsConfig2.size();
        String[] hosts2 = new String[sizeHost2];
        String[] users2 = new String[sizeHost2];
        String[] passwords2 = new String[sizeHost2];
        int[] ports2 = new int[sizeHost2];
        copyFromHostConfigArray(hostsConfig2, hosts2, users2, passwords2, ports2);
        Sheet421CoreConfig.setInspectedHosts2(hosts2);
        Sheet421CoreConfig.setPasswords2(passwords2);
        Sheet421CoreConfig.setUsers2(users2);
        Sheet421CoreConfig.setPasswords2(passwords2);
        Sheet421CoreConfig.setPorts2(ports2);

        ArrayList<HostConfig> hostsConfig35 = connectorParser.getHostsInspectionConfig()
                .getSheet421Parser().getCore().getHosts35();
        int sizeHost35 = hostsConfig35.size();
        String[] hosts35 = new String[sizeHost35];
        String[] users35 = new String[sizeHost35];
        String[] passwords35 = new String[sizeHost35];
        int[] ports35 = new int[sizeHost35];
        copyFromHostConfigArray(hostsConfig35, hosts35, users35, passwords35, ports35);
        Sheet421CoreConfig.setInspectedHosts35(hosts35);
        Sheet421CoreConfig.setPasswords35(passwords35);
        Sheet421CoreConfig.setUsers35(users35);
        Sheet421CoreConfig.setPasswords35(passwords35);
        Sheet421CoreConfig.setPorts35(ports35);

        ArrayList<HostConfig> hostsConfig4 = connectorParser.getHostsInspectionConfig()
                .getSheet421Parser().getCore().getHosts4();
        int sizeHost4 = hostsConfig4.size();
        String[] hosts4 = new String[sizeHost4];
        String[] users4 = new String[sizeHost4];
        String[] passwords4 = new String[sizeHost4];
        int[] ports4 = new int[sizeHost4];
        copyFromHostConfigArray(hostsConfig4, hosts4, users4, passwords4, ports4);
        Sheet421CoreConfig.setInspectedHosts4(hosts4);
        Sheet421CoreConfig.setPasswords4(passwords4);
        Sheet421CoreConfig.setUsers4(users4);
        Sheet421CoreConfig.setPasswords4(passwords4);
        Sheet421CoreConfig.setPorts4(ports4);
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
