package org.lin.monitor.manager.configurator.connector;

import org.lin.monitor.manager.parser.connector.ConnectorParser;
import org.lin.monitor.manager.parser.connector.HostConfig;
import org.suns.data.collector.config.sheet411.Sheet411CoreConfig;
import org.suns.data.collector.config.sheet411.Sheet411PersonalConfig;

import java.util.ArrayList;

/**
 * Created by guanl on 7/17/2017.
 */
public class DataCollectorSheet411Configurator {
    private ConnectorParser connectorParser;

    public DataCollectorSheet411Configurator(ConnectorParser connectorParser) {
        this.connectorParser = connectorParser;
    }

    public DataCollectorSheet411Configurator() {
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
                .getSheet411Parser().getPersonal().getRootDirectory();
        Sheet411PersonalConfig.setRootDirectory(rootDirectory);

        String softwareDirectory = connectorParser.getHostsInspectionConfig()
                .getSheet411Parser().getPersonal().getSoftwareDirectory();
        Sheet411PersonalConfig.setSoftwareDirectory(softwareDirectory);

        ArrayList<HostConfig> hostsConfig2 = connectorParser.getHostsInspectionConfig()
                .getSheet411Parser().getPersonal().getHosts2();
        int sizeHost2 = hostsConfig2.size();
        String[] hosts2 = new String[sizeHost2];
        String[] users2 = new String[sizeHost2];
        String[] passwords2 = new String[sizeHost2];
        int[] ports2 = new int[sizeHost2];
        copyFromHostConfigArray(hostsConfig2, hosts2, users2, passwords2, ports2);
        Sheet411PersonalConfig.setInspectedHosts2(hosts2);
        Sheet411PersonalConfig.setPasswords2(passwords2);
        Sheet411PersonalConfig.setUsers2(users2);
        Sheet411PersonalConfig.setPasswords2(passwords2);
        Sheet411PersonalConfig.setPorts2(ports2);

        ArrayList<HostConfig> hostsConfig3 = connectorParser.getHostsInspectionConfig()
                .getSheet411Parser().getPersonal().getHosts3();
        int sizeHost3 = hostsConfig3.size();
        String[] hosts3 = new String[sizeHost3];
        String[] users3 = new String[sizeHost3];
        String[] passwords3 = new String[sizeHost3];
        int[] ports3 = new int[sizeHost3];
        copyFromHostConfigArray(hostsConfig3, hosts3, users3, passwords3, ports3);
        Sheet411PersonalConfig.setInspectedHosts3(hosts3);
        Sheet411PersonalConfig.setPasswords3(passwords3);
        Sheet411PersonalConfig.setUsers3(users3);
        Sheet411PersonalConfig.setPasswords3(passwords3);
        Sheet411PersonalConfig.setPorts3(ports3);

        ArrayList<HostConfig> hostsConfig45 = connectorParser.getHostsInspectionConfig()
                .getSheet411Parser().getPersonal().getHosts45();
        int sizeHost45 = hostsConfig45.size();
        String[] hosts45 = new String[sizeHost45];
        String[] users45 = new String[sizeHost45];
        String[] passwords45 = new String[sizeHost45];
        int[] ports45 = new int[sizeHost45];
        copyFromHostConfigArray(hostsConfig45, hosts45, users45, passwords45, ports45);
        Sheet411PersonalConfig.setInspectedHosts45(hosts45);
        Sheet411PersonalConfig.setPasswords45(passwords45);
        Sheet411PersonalConfig.setUsers45(users45);
        Sheet411PersonalConfig.setPasswords45(passwords45);
        Sheet411PersonalConfig.setPorts45(ports45);
    }
    
    public void configureCore() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        String rootDirectory = connectorParser.getHostsInspectionConfig()
                .getSheet411Parser().getCore().getRootDirectory();
        Sheet411CoreConfig.setRootDirectory(rootDirectory);

        String softwareDirectory = connectorParser.getHostsInspectionConfig()
                .getSheet411Parser().getCore().getSoftwareDirectory();
        Sheet411CoreConfig.setSoftwareDirectory(softwareDirectory);

        ArrayList<HostConfig> hostsConfig2 = connectorParser.getHostsInspectionConfig()
                .getSheet411Parser().getCore().getHosts2();
        int sizeHost2 = hostsConfig2.size();
        String[] hosts2 = new String[sizeHost2];
        String[] users2 = new String[sizeHost2];
        String[] passwords2 = new String[sizeHost2];
        int[] ports2 = new int[sizeHost2];
        copyFromHostConfigArray(hostsConfig2, hosts2, users2, passwords2, ports2);
        Sheet411CoreConfig.setInspectedHosts2(hosts2);
        Sheet411CoreConfig.setPasswords2(passwords2);
        Sheet411CoreConfig.setUsers2(users2);
        Sheet411CoreConfig.setPasswords2(passwords2);
        Sheet411CoreConfig.setPorts2(ports2);

        ArrayList<HostConfig> hostsConfig3 = connectorParser.getHostsInspectionConfig()
                .getSheet411Parser().getCore().getHosts3();
        int sizeHost3 = hostsConfig3.size();
        String[] hosts3 = new String[sizeHost3];
        String[] users3 = new String[sizeHost3];
        String[] passwords3 = new String[sizeHost3];
        int[] ports3 = new int[sizeHost3];
        copyFromHostConfigArray(hostsConfig3, hosts3, users3, passwords3, ports3);
        Sheet411CoreConfig.setInspectedHosts3(hosts3);
        Sheet411CoreConfig.setPasswords3(passwords3);
        Sheet411CoreConfig.setUsers3(users3);
        Sheet411CoreConfig.setPasswords3(passwords3);
        Sheet411CoreConfig.setPorts3(ports3);

        ArrayList<HostConfig> hostsConfig4 = connectorParser.getHostsInspectionConfig()
                .getSheet411Parser().getCore().getHosts4();
        int sizeHost4 = hostsConfig4.size();
        String[] hosts4 = new String[sizeHost4];
        String[] users4 = new String[sizeHost4];
        String[] passwords4 = new String[sizeHost4];
        int[] ports4 = new int[sizeHost4];
        copyFromHostConfigArray(hostsConfig4, hosts4, users4, passwords4, ports4);
        Sheet411CoreConfig.setInspectedHosts4(hosts4);
        Sheet411CoreConfig.setPasswords4(passwords4);
        Sheet411CoreConfig.setUsers4(users4);
        Sheet411CoreConfig.setPasswords4(passwords4);
        Sheet411CoreConfig.setPorts4(ports4);

        ArrayList<HostConfig> hostsConfig5 = connectorParser.getHostsInspectionConfig()
                .getSheet411Parser().getCore().getHosts5();
        int sizeHost5 = hostsConfig5.size();
        String[] hosts5 = new String[sizeHost5];
        String[] users5 = new String[sizeHost5];
        String[] passwords5 = new String[sizeHost5];
        int[] ports5 = new int[sizeHost5];
        copyFromHostConfigArray(hostsConfig5, hosts5, users5, passwords5, ports5);
        Sheet411CoreConfig.setInspectedHosts5(hosts5);
        Sheet411CoreConfig.setPasswords5(passwords5);
        Sheet411CoreConfig.setUsers5(users5);
        Sheet411CoreConfig.setPasswords5(passwords5);
        Sheet411CoreConfig.setPorts5(ports5);

        ArrayList<HostConfig> hostsConfig6 = connectorParser.getHostsInspectionConfig()
                .getSheet411Parser().getCore().getHosts6();
        int sizeHost6 = hostsConfig6.size();
        String[] hosts6 = new String[sizeHost6];
        String[] users6 = new String[sizeHost6];
        String[] passwords6 = new String[sizeHost6];
        int[] ports6 = new int[sizeHost6];
        copyFromHostConfigArray(hostsConfig6, hosts6, users6, passwords6, ports6);
        Sheet411CoreConfig.setInspectedHosts6(hosts6);
        Sheet411CoreConfig.setPasswords6(passwords6);
        Sheet411CoreConfig.setUsers6(users6);
        Sheet411CoreConfig.setPasswords6(passwords6);
        Sheet411CoreConfig.setPorts6(ports6);

        ArrayList<HostConfig> hostsConfig8 = connectorParser.getHostsInspectionConfig()
                .getSheet411Parser().getCore().getHosts8();
        int sizeHost8 = hostsConfig8.size();
        String[] hosts8 = new String[sizeHost8];
        String[] users8 = new String[sizeHost8];
        String[] passwords8 = new String[sizeHost8];
        int[] ports8 = new int[sizeHost8];
        copyFromHostConfigArray(hostsConfig8, hosts8, users8, passwords8, ports8);
        Sheet411CoreConfig.setInspectedHosts8(hosts8);
        Sheet411CoreConfig.setPasswords8(passwords8);
        Sheet411CoreConfig.setUsers8(users8);
        Sheet411CoreConfig.setPasswords8(passwords8);
        Sheet411CoreConfig.setPorts8(ports8);
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
