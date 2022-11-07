package com.toaiko.toaikocraft.item;

import com.toaiko.toaikocraft.TOAIKOCraft;
import net.minecraft.item.Item;

public class TOAIKOFishItem extends Item {
    public TOAIKOFishItem(Properties properties) {
        super(properties);
    }

    public TOAIKOFishItem() {
        super(new Item.Properties().tab(TOAIKOCraft.TAB));
    }
}
