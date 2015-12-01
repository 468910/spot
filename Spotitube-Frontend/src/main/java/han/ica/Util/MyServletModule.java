package han.ica.Util;

import Domain.Service.RemotePlayListService;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import han.ica.PageControllers.AddTrackPageController;
import han.ica.PageControllers.PlaylistViewPageController;
import Domain.Service.PlaylistService;
import han.ica.Service.PlaylistRestImpl;
import han.ica.Service.PlaylistServiceRemoteAdapter;
import han.ica.Service.PlaylistServiceRemoteImpl;
import han.ica.Service.PlaylistSeviceImpl;

/**
 * Created by apple on 16/10/15.
 */
public class MyServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        super.configureServlets();

        serve("/playlist").with(PlaylistViewPageController.class);
        serve("/addtrack").with(AddTrackPageController.class);

        // SERVICE


        bind(PlaylistService.class).to(PlaylistRestImpl.class).in(Singleton.class);
        bind(RemotePlayListService.class).to(PlaylistServiceRemoteImpl.class).in(Singleton.class);


    }
}
