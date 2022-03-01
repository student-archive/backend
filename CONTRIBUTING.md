# Contributing

We love contributions from everyone.
By participating in this project,
you agree to abide by the dadyarri [code of conduct].

[code of conduct]: CODE_OF_CONDUCT.md

We expect everyone to follow the code of conduct
anywhere in StAr project codebases,
issue trackers and chatrooms.

## Bug reports

If you think you have found a bug in Star,
first make sure that you are testing against the latest version
of Star - your issue may already have been fixed.
If not, search our [issues list] on GitHub in case a similar issue
has already been opened.

## Feature request

If you find yourself wishing for a feature that doesn't exist
in Star, you are probably not alone. There are bound
to be others out there with similar needs. Many of the features
that Star has today have been added because our users saw
the need. Open an issue on our [issues list] on GitHub which describes
the feature you would like to see, why you need it, and how it should work.

## Contributing code and documentation changes

If you would like to contribute a new feature or a bug fix to Star,
please discuss your idea first on the GitHub issue. If there is no GitHub issue
for your idea, please open one. It may be that somebody is already working
on it, or that there are particular complexities that you should know about
before starting the implementation. There are often a number of ways to fix
a problem, and it is important to find the right approach before spending
time on a PR that cannot be merged.

We add the help wanted label to existing GitHub issues for which community
contributions are particularly welcome, and we use the good first issue
label to mark issues that we think will be suitable for new contributors.

### Fork and clone the repository
You will need to fork the main Star repository and clone it to your local machine.
See [github help page](https://docs.github.com/en/get-started/quickstart/fork-a-repo) for help.

### Tips for code changes
Following these tips prior to raising a pull request will speed up the
review cycle.

- Add appropriate unit tests (details on writing tests can be found in the
TESTING file)
- Add integration tests, if applicable
- Make sure the code you add follows the [formatting guidelines](https://google.github.io/styleguide/javaguide.html)
- Lines that are not part of your change should not be edited (e.g. don't format unchanged lines, don't reorder existing imports)
- Add the appropriate license headers to any new files

[issues list]: https://github.com/dadyarri/star/issues

### Javadoc

Good Javadoc can help with navigating and understanding code. Star
has some guidelines around when to write Javadoc and when not to, but note
that we don't want to be overly prescriptive. The intent of these guidelines
is to be helpful, not to turn writing code into a chore.

#### The short version

1. Always add Javadoc to new code.
2. Add Javadoc to existing code if you can.
3. Document the "why", not the "how", unless that's important to the
   "why".
4. Don't document anything trivial or obvious (e.g. getters and
   setters). In other words, the Javadoc should add some value.

#### The long version

1. If you add a new Java package, please also add package-level
   Javadoc that explains what the package is for. This can just be a
   reference to a more foundational / parent package if appropriate. An
   example would be a package hierarchy for a new feature or plugin -
   the package docs could explain the purpose of the feature, any
   caveats, and possibly some examples of configuration and usage.
2. New classes and interfaces must have class-level Javadoc that
   describes their purpose. There are a lot of classes in the
   Star repository, and it's easier to navigate when you
   can quickly find out what is the purpose of a class. This doesn't
   apply to inner classes or interfaces, unless you expect them to be
   explicitly used outside their parent class.
3. New public methods must have Javadoc, because they form part of the
   contract between the class and its consumers. Similarly, new abstract
   methods must have Javadoc because they are part of the contract
   between a class and its subclasses. It's important that contributors
   know why they need to implement a method, and the Javadoc should make
   this clear. You don't need to document a method if it's overriding an
   abstract method (either from an abstract superclass or an interface),
   unless your implementation is doing something "unexpected" e.g. deviating
   from the intent of the original method.
4. Following on from the above point, please add docs to existing public
   methods if you are editing them, or to abstract methods if you can.
5. Non-public, non-abstract methods don't require Javadoc, but if you feel
   that adding some would make it easier for other developers to
   understand the code, or why it's written in a particular way, then please
   do so.
6. Properties don't need to have Javadoc, but please add some if there's
   something useful to say.
7. Javadoc should not go into low-level implementation details unless
   this is critical to understanding the code e.g. documenting the
   subtleties of the implementation of a private method. The point here
   is that implementations will change over time, and the Javadoc is
   less likely to become out-of-date if it only talks about the what is
   the purpose of the code, not what it does.
8. Examples in Javadoc can be very useful, so feel free to add some if
   you can reasonably do so i.e. if it takes a whole page of code to set
   up an example, then Javadoc probably isn't the right place for it.
   Longer or more elaborate examples are probably better suited
   to the package docs.
9. Test methods are a good place to add Javadoc, because you can use it
   to succinctly describe e.g. preconditions, actions and expectations
   of the test, more easily that just using the test name alone. Please
   consider documenting your tests in this way.
10. Sometimes you shouldn't add Javadoc:
    1. Where it adds no value, for example where a method's
       implementation is trivial such as with getters and setters, or a
       method just delegates to another object.
    2. However, you should still add Javadoc if there are caveats around
       calling a method that are not immediately obvious from reading the
       method's implementation in isolation.
    3. You can omit Javadoc for simple classes, e.g. where they are a
       simple container for some data. However, please consider whether a
       reader might still benefit from some additional background, for
       example about why the class exists at all.
11. Not all comments need to be Javadoc. Sometimes it will make more
    sense to add comments in a method's body, for example due to important
    implementation decisions or "gotchas". As a general guide, if some
    information forms part of the contract between a method and its callers,
    then it should go in the Javadoc, otherwise you might consider using
    regular comments in the code.
    * If a method's performance is "unexpected" then it's good to call that
      out in the Javadoc. This is especially helpful if the method is usually fast but sometimes
      very slow (shakes fist at caching).
12. Please still try to make class, method or variable names as
    descriptive and concise as possible, as opposed to relying solely on
    Javadoc to describe something.
13. Use `@link` to add references to related resources in the codebase. Or
    outside the code base.
    1. `@see` is much more limited than `@link`. You can use it but most of
       the time `@link` flows better.
14. If you need help writing Javadoc, just ask!

Finally, use your judgement! Base your decisions on what will help other
developers - including yourself, when you come back to some code
3 months in the future, having forgotten how it works.
