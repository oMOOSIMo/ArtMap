package me.Fupery.ArtMap.Menu.Button;

import me.Fupery.ArtMap.ArtMap;
import me.Fupery.ArtMap.Menu.API.MenuTemplate;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

public class LinkedButton extends Button {

    private final MenuTemplate linkedMenu;

    public LinkedButton(MenuTemplate linkedMenu, Material material) {
        super(material);
        this.linkedMenu = linkedMenu;
    }

    public LinkedButton(MenuTemplate linkedMenu, Material material, int durability) {
        super(material, durability);
        this.linkedMenu = linkedMenu;
    }

    public LinkedButton(MenuTemplate linkedMenu, Material material, String displayName, String... lore) {
        super(material, displayName, lore);
        this.linkedMenu = linkedMenu;
    }

    public LinkedButton(MenuTemplate linkedMenu, Material material, int durability,
                        String displayName, String... lore) {
        super(material, durability, displayName, lore);
        this.linkedMenu = linkedMenu;
    }

    public LinkedButton(MenuTemplate linkedMenu, Material material, int durability, String... text) {
        super(material, durability, text);
        this.linkedMenu = linkedMenu;
    }

    public LinkedButton(MenuTemplate linkedMenu, Material material, String... text) {
        super(material, text);
        this.linkedMenu = linkedMenu;
    }

    @Override
    public void onClick(Player player, ClickType clickType) {
//        ArtMap.getMenuHandler().openMenu(player, linkedMenu);
    }
}
