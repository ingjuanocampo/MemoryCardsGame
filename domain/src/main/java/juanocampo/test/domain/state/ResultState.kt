package juanocampo.test.domain.state


sealed class ResultState

data class SuccessState<T>(val data: T): ResultState()
data class ErrorState(val throwable: Throwable): ResultState()