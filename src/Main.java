import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnknownHostException {
        List<RoutingTable> routingTables = new ArrayList<RoutingTable>();
        ArrayList<String> frames = new ArrayList<String>();
        File frame = new File("/Volumes/HDD/Routing/src/frameDestinationAddress.txt");
        frames = ReadFrame(frame,frames);
        File routingTable = new File("/Volumes/HDD/Routing/src/routingTable.txt");
        routingTables= ReadRoutingTable(routingTable,routingTables);
        boolean flag = false;
        for(int i =0; i<frames.size();i++)
        {
            for (RoutingTable r : routingTables)
            {
                  if (r.getIPAddress().equalsIgnoreCase(frames.get(i)))
                  {
                      System.out.println("Frame with destination address "+frames.get(i)+" "+r.getNextHop()+" on Interface "+r.getRouterInterface());
                      frames.remove(i);
                  }
            }
        }
        for(int i =0; i<frames.size();i++)
        {
            for (RoutingTable r : routingTables)
            {
                Boolean sameNetwork = sameNetwork(r.getIPAddress(),frames.get(i),r.getMask());
               if (sameNetwork==true)
               {
                   System.out.println("Frame with destination address "+frames.get(i)+" "+r.getNextHop()+" on Interface "+r.getRouterInterface());
                   break;
               }
            }
        }
    }

    private static boolean sameNetwork(String ipAddress, String destination, String mask) throws UnknownHostException {
        byte[] ip1 = InetAddress.getByName(ipAddress).getAddress();
        byte[] ip2 = InetAddress.getByName(destination).getAddress();
        byte[] m = InetAddress.getByName(mask).getAddress();

        for (int i = 0; i < ip1.length; i++)

            if ((ip1[i] & m[i]) != (ip2[i] & m[i]))
                return false;

            return true;


    }


    private static List<RoutingTable> ReadRoutingTable(File routingTable, List<RoutingTable> routingTables) throws FileNotFoundException {
        Scanner sc = new Scanner(routingTable);
        while (sc.hasNextLine())
        {
            String nextHop = "";
            String[] tempSpit = new String[5];
            String temp = sc.nextLine();
            tempSpit = temp.split("\\s+");
            if(tempSpit[2].equalsIgnoreCase("-"))
            {
                nextHop="will not be forwarded anywhere as destination is directly connected to the Network";
            }
            else
            {
                nextHop = "will be forwarded to"+ " "+tempSpit[2];
            }
            RoutingTable routingTable1 = new RoutingTable(tempSpit[0],tempSpit[1],nextHop,tempSpit[3],tempSpit[4]);
            routingTables.add(routingTable1);
        }
        return routingTables;

    }

    private static ArrayList<String> ReadFrame(File frame, ArrayList<String> frames) throws FileNotFoundException {
        Scanner sc = new Scanner(frame);
        while (sc.hasNextLine())
        {
            frames.add(sc.nextLine());
        }
        return frames;
    }
}
