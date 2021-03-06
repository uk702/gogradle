package com.github.blindpirate.gogradle.core.dependency.produce.external.gopm;

import com.github.blindpirate.gogradle.core.dependency.parse.MapNotationParser;
import com.github.blindpirate.gogradle.core.dependency.produce.ExternalDependencyFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Converts .gopmfile in repos managed by godep to gogradle map notations.
 *
 * @see <a href="https://github.com/gpmgo/gopm">gopm</a>
 */
@Singleton
public class GopmDependencyFactory extends ExternalDependencyFactory {

    private GopmfileParser gopmfileParser = new GopmfileParser();

    @Inject
    public GopmDependencyFactory(MapNotationParser mapNotationParser) {
        super(mapNotationParser);
    }

    @Override
    protected String identityFileName() {
        return ".gopmfile";
    }

    @Override
    protected List<Map<String, Object>> adapt(File file) {
        return gopmfileParser.parse(file);
    }
}
