package ica.han.Domain.REST;

import Domain.Service.RemotePlayListService;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import ica.han.Domain.POJO.RemotePlaylistServiceImpl;

/**
 * Created by apple on 22/10/15.
 */

public class MyServletModule extends ServletModule{
    @Override
    protected void configureServlets() {
        super.configureServlets();

        bind(RemotePlayListService.class).to(RemotePlaylistServiceImpl.class).in(Singleton.class);

    }
}
