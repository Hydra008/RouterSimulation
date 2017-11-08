/**
 * Created by Godfather on 2017-11-07.
 */
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

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public String getNextHop() {
        return nextHop;
    }

    public void setNextHop(String nextHop) {
        this.nextHop = nextHop;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRouterInterface() {
        return routerInterface;
    }

    public void setRouterInterface(String routerInterface) {
        this.routerInterface = routerInterface;
    }
}
