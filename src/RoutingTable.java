/**
 * Created by Godfather on 2017-11-07.
 */

// A model routing table row
public class RoutingTable {
    private String mask;
    private String IPAddress;
    private String nextHop;
    private String flag;
    private String routerInterface;

    public RoutingTable(){}

    public RoutingTable(String mask, String IPAddress, String nextHop, String flag, String routerInterface) {
        this.mask = mask;
        this.IPAddress = IPAddress;
        this.nextHop = nextHop;
        this.flag = flag;
        this.routerInterface = routerInterface;
    }

    public String getMask() {
        return mask;
    }


    public String getIPAddress() {
        return IPAddress;
    }


    public String getNextHop() {
        return nextHop;
    }


    public String getFlag() {
        return flag;
    }


    public String getRouterInterface() {
        return routerInterface;
    }

}
