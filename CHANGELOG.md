
[UNRELEASED] Release 2.2.0:

Release 2.1.0:
- Add: Serialization for `NormalizedJsonPathSegment`, `NormalizedJsonPath` and `NodeListEntry`

Release 2.0.0:
- BREAKING CHANGE to `JsonPathFunctionExtension`: breaks specification syntax for function extensions, but provides simpler definition syntax.
  - The function extensions no longer hold a name. A name must only be provided when adding a function extension to a repository
  - The function extension classes are no longer inheritable. Instances must be created from constructors.
- BREAKING CHANGE to `JsonPathFunctionExtensionRepository`: 
  - Changed `addExtension`: 
    - Takes an additional parameter for the function extension name  
    - The function extension is now constructed only when necessary, which has been changed mostly because the definition syntax now feels cleaner.
- BREAKING CHANGE to `JsonPathCompiler`:
  - Changed `compile`: Takes the function extension retriever as second argument now

Release 1.0.0:
- Add `JsonPath`: JsonPath compiler and query functionality
- Add `JsonPathDependencyManager`: Dependency manager for the library
- Add `JsonPathFunctionExtensionRepository`: Give users a way to add custom function extensions 

