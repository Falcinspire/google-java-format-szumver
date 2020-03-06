# google-java-format-szumver

This is a fork of the google-java-format project that seeks to conform to the style guide set by 
UCF's Sean Szulmanski. This project may require permission from Sean Szulmanski for its 
naming or usage. It is almost fully functional, but is still a work-in-progress.

WARNING: This program is not responsible for loss of code/problems that it may cause. Always backup
your source code, using either a local .git or some other manual or automatic backup service. This program 
is ALSO not responsible for ensuring the complete formatting correctness of your program (Although I
hope it outputs as such).

NOTE: I modified ~100 lines of code; the vast majority of this codebase is not my work. Use
the commit history to see where this project and the original diverged. HUGE thanks to the
original Google authors of google-java-format. 

# Quick Start

Download the jar from the [Releases][] tab. Install the jar anywhere into your System Path, or just put
the jar in with the rest of your source code. Execute `java -jar google-java-format-szumver-1.0.jar -r <.java file>`.

[Releases]: https://github.com/Falcinspire/google-java-format-szumver/releases

# Specifications

This format does not exactly match Sean Szulmanski's, but should be a subset of it. The var keyword is currently
not handled.

* A header must be included with // comments at the very top of the file, in the format:
```java
// <Full Name>
// Course Number/String>, <Spring|Fall|Summer> <4-digit (with MSD != 0) non-negative Semester Year>
// <Description of program in 1+ lines>
```
* Slash-star comments (/* */) are dissallowed anywhere in the file.
* Slash-slash comments (//) are dissallowed when trailing statements (but OK on lines by themselves).
* Indenting is done with 4 spaces per level
* All methods in a file are seperated by a blank line
* Braces are Allman style
* Max column width is 100
* By default, any formatting not listed here is handled by the the style guide set by Google.

A few rules (commenting and header) will not be automaticaly corrected, and warnings will display
in the syserr stream (usually the console).
The rest of this README is copied from the original project.

# google-java-format

`google-java-format` is a program that reformats Java source code to comply with
[Google Java Style][].

[Google Java Style]: https://google.github.io/styleguide/javaguide.html

## Using the formatter

### from the command-line

[Download the formatter](https://github.com/google/google-java-format/releases)
and run it with:

```
java -jar /path/to/google-java-format-1.7-all-deps.jar <options> [files...]
```

The formatter can act on whole files, on limited lines (`--lines`), on specific
offsets (`--offset`), passing through to standard-out (default) or altered
in-place (`--replace`).

To reformat changed lines in a specific patch, use
[`google-java-format-diff.py`](https://github.com/google/google-java-format/blob/master/scripts/google-java-format-diff.py).

***Note:*** *There is no configurability as to the formatter's algorithm for
formatting. This is a deliberate design decision to unify our code formatting on
a single format.*

### IntelliJ, Android Studio, and other JetBrains IDEs

A
[google-java-format IntelliJ plugin](https://plugins.jetbrains.com/plugin/8527)
is available from the plugin repository. To install it, go to your IDE's
settings and select the `Plugins` category. Click the `Marketplace` tab, search
for the `google-java-format` plugin, and click the `Install` button.

The plugin will be disabled by default. To enable it in the current project, go
to `File→Settings...→google-java-format Settings` (or `IntelliJ
IDEA→Preferences...→Other Settings→google-java-format Settings` on macOS) and
check the `Enable google-java-format` checkbox. (A notification will be
presented when you first open a project offering to do this for you.)

To enable it by default in new projects, use `File→Other Settings→Default
Settings...`.

When enabled, it will replace the normal `Reformat Code` action, which can be
triggered from the `Code` menu or with the Ctrl-Alt-L (by default) keyboard
shortcut.

The import ordering is not handled by this plugin, unfortunately. To fix the
import order, download the
[IntelliJ Java Google Style file](https://raw.githubusercontent.com/google/styleguide/gh-pages/intellij-java-google-style.xml)
and import it into File→Settings→Editor→Code Style.

### Eclipse

A
[google-java-format Eclipse plugin](https://github.com/google/google-java-format/releases/download/google-java-format-1.6/google-java-format-eclipse-plugin_1.6.0.jar)
can be downloaded from the releases page. Drop it into the Eclipse
[drop-ins folder](http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fmisc%2Fp2_dropins_format.html)
to activate the plugin.

The plugin adds a `google-java-format` formatter implementation that can be
configured in `Window > Preferences > Java > Code Style > Formatter > Formatter
Implementation`.

### Third-party integrations

*   Gradle plugins
    *   [Spotless](https://github.com/diffplug/spotless/tree/master/plugin-gradle#applying-to-java-source-google-java-format):
    *   [sherter/google-java-format-gradle-plugin](https://github.com/sherter/google-java-format-gradle-plugin)
*   Apache Maven plugins
    *   [coveo/fmt-maven-plugin](https://github.com/coveo/fmt-maven-plugin)
    *   [talios/googleformatter-maven-plugin](https://github.com/talios/googleformatter-maven-plugin)
    *   [Cosium/maven-git-code-format](https://github.com/Cosium/maven-git-code-format):
        A maven plugin that automatically deploys google-java-format as a
        pre-commit git hook.
*   SBT plugins
    *   [sbt/sbt-java-formatter](https://github.com/sbt/sbt-java-formatter)
*   [maltzj/google-style-precommit-hook](https://github.com/maltzj/google-style-precommit-hook):
    A pre-commit (pre-commit.com) hook that will automatically run GJF whenever
    you commit code to your repository

### as a library

The formatter can be used in software which generates java to output more
legible java code. Just include the library in your maven/gradle/etc.
configuration.

#### Maven

```xml
<dependency>
  <groupId>com.google.googlejavaformat</groupId>
  <artifactId>google-java-format</artifactId>
  <version>1.7</version>
</dependency>
```

#### Gradle

```groovy
dependencies {
  compile 'com.google.googlejavaformat:google-java-format:1.7'
}
```

You can then use the formatter through the `formatSource` methods. E.g.

```java
String formattedSource = new Formatter().formatSource(sourceString);
```

or

```java
CharSource source = ...
CharSink output = ...
new Formatter().formatSource(source, output);
```

Your starting point should be the instance methods of
`com.google.googlejavaformat.java.Formatter`.

## Building from source

```
mvn install
```

## Contributing

Please see [the contributors guide](CONTRIBUTING.md) for details.

## License

```text
Copyright 2015 Google Inc.

Licensed under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
```
