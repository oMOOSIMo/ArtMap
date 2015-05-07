package me.Fupery.Artiste.Command.CanvasCommands;

import me.Fupery.Artiste.Canvas;
import me.Fupery.Artiste.CommandListener;
import me.Fupery.Artiste.StartClass;
import me.Fupery.Artiste.IO.Artist;
import me.Fupery.Artiste.MapArt.Buffer;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Unclaim extends CanvasCommand {

	public Unclaim(CommandListener listener) {

		super(listener);
		claimRequired = true;
		artistRequired = true;
		usage = "unclaim";

		success = ChatColor.GOLD + "You have unclaimed the canvas, "
				+ "your work will be saved for later!";
	}

	protected boolean run() {

		unclaim();

		return true;
	}

	public static void unclaim() {

		Canvas c = StartClass.canvas;

		if (c == null)
			return;

		Player p = c.getOwner();

		if (p == null)
			return;

		Artist artist = StartClass.artistList.get(p.getUniqueId());

		artist.setBuffer(new Buffer());

		if (StartClass.canvas != null)

			StartClass.canvas.clear(p);

		if (StartClass.claimTimer != null)

			StartClass.claimTimer.cancel();
	}

}
