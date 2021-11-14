package fr.emotion.emomod;

import net.minecraftforge.eventbus.api.IEventBus;

public class ClientSideOnlyEventRegister
{
	private final IEventBus eventBus;

	public ClientSideOnlyEventRegister(IEventBus eventBus)
	{
		this.eventBus = eventBus;
	}

	public void registerClientOnlyEvents()
	{
		eventBus.register(StartupClientOnly.class);
	}
}
