package org.assimbly.gateway.web.rest;

import org.assimbly.gateway.config.ApplicationProperties;
import org.assimbly.gateway.config.DefaultProfileUtil;

import io.github.jhipster.config.JHipsterProperties;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Resource to return information about the currently running Spring profiles.
 */
@RestController
@RequestMapping("/api")
public class ProfileInfoResource {

    private final Environment env;

    private final JHipsterProperties jHipsterProperties;

    private final ApplicationProperties.Documentation documentation;

    
    public ProfileInfoResource(Environment env, JHipsterProperties jHipsterProperties, ApplicationProperties applicationProperties) {
        this.env = env;
        this.jHipsterProperties = jHipsterProperties;
        this.documentation = applicationProperties.getDocumentation();
    }

    @GetMapping("/profile-info")
    public ProfileInfoVM getActiveProfiles() {
        String[] activeProfiles = DefaultProfileUtil.getActiveProfiles(env);
        return new ProfileInfoVM(activeProfiles, getRibbonEnv(activeProfiles));
    }

    @GetMapping("/documentation/url")
    public String getUrl() {
    	System.out.println("get property url");
        String blabla = documentation.getCamelUrl();
        System.out.println("result: " + blabla);
        return blabla;
    }
    
    
    private String getRibbonEnv(String[] activeProfiles) {
        String[] displayOnActiveProfiles = jHipsterProperties.getRibbon().getDisplayOnActiveProfiles();
        if (displayOnActiveProfiles == null) {
            return null;
        }
        List<String> ribbonProfiles = new ArrayList<>(Arrays.asList(displayOnActiveProfiles));
        List<String> springBootProfiles = Arrays.asList(activeProfiles);
        ribbonProfiles.retainAll(springBootProfiles);
        if (!ribbonProfiles.isEmpty()) {
            return ribbonProfiles.get(0);
        }
        return null;
    }

    class ProfileInfoVM {

        private String[] activeProfiles;

        private String ribbonEnv;

        ProfileInfoVM(String[] activeProfiles, String ribbonEnv) {
            this.activeProfiles = activeProfiles;
            this.ribbonEnv = ribbonEnv;
        }

        public String[] getActiveProfiles() {
            return activeProfiles;
        }

        public String getRibbonEnv() {
            return ribbonEnv;
        }
    }
}
