package at.asitplus.jsonpath.core

interface JsonPathCompiler {
    fun compile(
        jsonPath: String,
        functionExtensionRetriever: (String) -> JsonPathFunctionExtension<*>?
    ): JsonPathQuery
}