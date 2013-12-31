package com.teammetallurgy.metallurgy.machines.crusher;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerCrusher extends Container
{

    private TileEntityMetallurgySided crusher;

    public ContainerCrusher(InventoryPlayer inventoryPlayer, TileEntityMetallurgySided tileEntity)
    {
        this.crusher = tileEntity;
        addPlayersInventoryToContainer(inventoryPlayer, 8, 84);
    }

    private void addPlayersInventoryToContainer(InventoryPlayer inventoryPlayer, int xStart, int yStart)
    {
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, xStart + j * 18, yStart + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, xStart + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return this.crusher.isUseableByPlayer(entityplayer);
    }

}
