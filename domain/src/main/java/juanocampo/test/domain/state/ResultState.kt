package juanocampo.test.domain.state


sealed class ResultState<T>

data class SuccessState<T>(val data: T): ResultState<T>()
data class ErrorState<T>(val throwable: Throwable): ResultState<T>()