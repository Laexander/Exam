import Player.*;

import static Player.PlayerColor.*;
import static Player.Race.*;


public class Main
{
    public static void main(String[] args) {
        Player player = new Player("TestName", Barony_of_Letnev, Green);

        System.out.println(player.toString());
    }
}
