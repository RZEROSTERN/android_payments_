package mx.yofio.core.data.network

import io.reactivex.Observable
import mx.yofio.core.domain.requests.LoginRequest
import mx.yofio.core.domain.requests.PaymentRequest
import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.core.domain.results.LoginResult
import mx.yofio.core.domain.results.MembershipPaymentsResult
import mx.yofio.core.domain.results.PaymentResult
import mx.yofio.core.domain.results.RegisterResult
import retrofit2.http.*

interface RestApi {
    @POST("customer")
    fun register(@Body registerRequest: UserRegisterRequest): Observable<RegisterResult>

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Observable<LoginResult>

    @GET("membership-payment")
    fun getPaymentsFromId(@Header("Authorization") token: String,
                      @Query("customer-id") id: String): Observable<MutableList<MembershipPaymentsResult>>

    @POST("membership-payment")
    fun pay(@Header("Authorization") token: String, @Body paymentRequest: PaymentRequest):
            Observable<PaymentResult>
}