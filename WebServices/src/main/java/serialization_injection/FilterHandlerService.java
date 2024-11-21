package serialization_injection;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class FilterHandlerService
{
    public FilterHandlerService() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    public void handleFavorites(FavoriteSymbolsRes favoriteSymbols)
    {
        log.info(favoriteSymbols);
    }
}
