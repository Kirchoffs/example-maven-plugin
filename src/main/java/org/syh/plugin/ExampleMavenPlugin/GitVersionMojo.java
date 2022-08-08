package org.syh.plugin.ExampleMavenPlugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import javax.inject.Inject;

@Mojo(name = "version", defaultPhase = LifecyclePhase.INITIALIZE)
public class GitVersionMojo extends AbstractMojo {
    /**
     * The command use to get the current git revision
     */
    @Parameter(property = "git.command", defaultValue = "git rev-parse --short HEAD")
    private String command;

    @Parameter(property = "project", readonly = true)
    private MavenProject project;

    @Inject
    VersionProvider versionProvider;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        String version = versionProvider.getVersion(command);
        project.getProperties().put("exampleVersion", version);
        getLog().info("Git hash: " + version);
    }
}
