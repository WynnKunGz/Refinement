package com.ablackpikatchu.refinement.core.util;

import com.ablackpikatchu.refinement.Refinement;
import com.ablackpikatchu.refinement.client.screen.GrinderScreen;
import com.ablackpikatchu.refinement.core.init.ContainerTypesInit;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Refinement.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.register(ContainerTypesInit.GRINDER_CONTAINER_TYPE.get(), GrinderScreen::new);
	}

}