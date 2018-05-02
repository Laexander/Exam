import player.*;

import static player.PlayerColor.*;
import static player.Race.*;


public class Main
{
    public static void main(String[] args) {
        Player player = new Player("TestName", Barony_of_Letnev, Green);

        System.out.println(player.toString());
    }
}
