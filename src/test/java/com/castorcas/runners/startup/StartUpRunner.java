package com.castorcas.runners.startup;

import com.castorcas.steps.startup.StartUpSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.ArrayList;
import java.util.List;

public class StartUpRunner extends JUnitStories{

    protected List<String> storyPaths() {

        String storySourcePath = "src/test/resources/";
        List<String> includesPath = new ArrayList<>();
        List<String> excludesPath = new ArrayList<>();

        includesPath.add("stories/startup/*.story");
        //excludesPath.add("stories/the-internet/windows-chrome/*.story");

        StoryFinder storyFinder = new StoryFinder();
        return storyFinder.findPaths(storySourcePath, includesPath, excludesPath);
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.HTML));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(
                configuration(),
                new StartUpSteps()
        );
    }
}
