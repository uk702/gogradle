package com.github.blindpirate.gogradle.core

import org.junit.Test

import static com.github.blindpirate.gogradle.core.StandardGolangPackage.of

class StandardGolangPackageTest {
    StandardGolangPackage standardGolangPackage = of('go/ast')

    @Test(expected = UnsupportedOperationException)
    void 'getVcsType should throw exception'() {
        of('incomplete').vcsType
    }

    @Test(expected = UnsupportedOperationException)
    void 'getUrl should throw exception'() {
        of('incomplete').urls
    }

    @Test
    void 'rootPath of a standard package should be itself'() {
        assert standardGolangPackage.rootPath == 'go/ast'
    }

    @Test
    void 'package generated by standard package should also be standard'() {
        assert standardGolangPackage.resolve('go').get() instanceof StandardGolangPackage
        assert standardGolangPackage.resolve('go/ast/ast').get() instanceof StandardGolangPackage
    }
}
