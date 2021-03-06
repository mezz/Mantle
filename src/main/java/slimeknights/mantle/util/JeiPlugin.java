package slimeknights.mantle.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.Rectangle;
import java.util.List;

import mezz.jei.api.IItemRegistry;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.IRecipeRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.gui.IAdvancedGuiHandler;
import slimeknights.mantle.client.gui.GuiMultiModule;

@JEIPlugin
public class JeiPlugin implements IModPlugin {
  @Override
  public void onJeiHelpersAvailable(IJeiHelpers jeiHelpers) {}

  @Override
  public void onItemRegistryAvailable(IItemRegistry itemRegistry) {}

  @Override
  public void register(IModRegistry registry) {
    registry.addAdvancedGuiHandlers(new IAdvancedGuiHandler<GuiMultiModule>() {
      @Nonnull
      @Override
      public Class<GuiMultiModule> getGuiContainerClass() {
        return GuiMultiModule.class;
      }

      @Nullable
      @Override
      public List<Rectangle> getGuiExtraAreas(@Nonnull GuiMultiModule guiContainer) {
        return guiContainer.getModuleAreas();
      }
    });
  }

  @Override
  public void onRecipeRegistryAvailable(IRecipeRegistry recipeRegistry) {}

  @Override
  public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {}
}
