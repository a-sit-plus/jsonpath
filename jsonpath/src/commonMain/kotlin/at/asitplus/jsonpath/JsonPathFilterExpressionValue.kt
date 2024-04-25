package at.asitplus.jsonpath

import kotlinx.serialization.json.JsonElement

sealed interface JsonPathFilterExpressionValue {
    val expressionType: JsonPathFilterExpressionType

    sealed class ValueTypeValue : JsonPathFilterExpressionValue {
        override val expressionType: JsonPathFilterExpressionType = JsonPathFilterExpressionType.ValueType
        data class JsonValue(val jsonElement: JsonElement) : ValueTypeValue()
        data object Nothing : ValueTypeValue()
    }

    data class LogicalTypeValue(val isTrue: Boolean) : JsonPathFilterExpressionValue {
        override val expressionType: JsonPathFilterExpressionType = JsonPathFilterExpressionType.LogicalType
    }

    sealed class NodesTypeValue(open val nodeList: List<JsonElement>) : JsonPathFilterExpressionValue {
        override val expressionType: JsonPathFilterExpressionType = JsonPathFilterExpressionType.NodesType

        sealed class FilterQueryResult(nodeList: List<JsonElement>): NodesTypeValue(nodeList) {
            data class SingularQueryResult(override val nodeList: List<JsonElement>): FilterQueryResult(nodeList)
            data class NonSingularQueryResult(override val nodeList: List<JsonElement>): FilterQueryResult(nodeList)
        }
        data class FunctionExtensionResult(override val nodeList: List<JsonElement>): NodesTypeValue(nodeList)
    }
}