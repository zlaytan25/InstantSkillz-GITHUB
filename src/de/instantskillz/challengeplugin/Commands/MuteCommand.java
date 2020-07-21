//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class MuteCommand implements CommandExecutor, Listener {

    private ArrayList<String> mutedPlayers = new ArrayList<>();

    @EventHandler
    public void handleMutedChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (mutedPlayers.contains(player.getName())) {
            player.sendMessage("§aServer " + "§8>> " + "§cDu bist aktuell gemutet und kannst daher nicht chatten!");
            event.setCancelled(true);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("schnellerHase.mute")) {
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {

                        if (!mutedPlayers.contains(target.getName())) {
                            mutedPlayers.add(target.getName());
                            player.sendMessage("§aServer " + "§8>> " + "§aDer Spieler §6" + target.getName() + " §awurde gemutet");
                            target.sendMessage("§aServer " + "§8>> " + "§cDu wurdest von §6" + player.getName() + " §cgemutet!");
                        } else {
                            mutedPlayers.remove(target.getName());
                            player.sendMessage("§aServer " + "§8>> " + "§aDer Spieler §6" + target.getName() + " §awurde entmutet!");
                            target.sendMessage("§aServer " + "§8>> " + "§aDu wurdest von §6" + player.getName() + " §aentmutet.");
                        }

                    } else
                        player.sendMessage("§aServer " + "§8>> " + "§cDer Spieler §6" + args[0] + " §c ist nicht auf dem Server.");
                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze §6/mute <SPIELER>§c!");
            } else
                player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Rechte");
        }

        return false;
    }

}
