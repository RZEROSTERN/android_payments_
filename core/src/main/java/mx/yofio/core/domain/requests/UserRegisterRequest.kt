package mx.yofio.core.domain.requests

data class UserRegisterRequest (
    var full_name: String,
    var phone_number: String,
    var email: String,
    var password: String
)