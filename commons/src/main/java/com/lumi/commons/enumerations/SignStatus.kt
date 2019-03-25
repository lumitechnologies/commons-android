package com.lumi.commons.enumerations

enum class SignStatus(private var identifier: String) {

    SIGN_SUCCESSFULLY("sign_successfully"),
    SIGN_ERROR("sign_error"),
    SIGN_CANCELED("sign_canceled");

    companion object {
        @JvmStatic
        fun fromIdentifier(identifier: String?): SignStatus? {
            if (identifier != null)
                for (value in SignStatus.values())
                    if (value.identifier == identifier)
                        return value

            assert(true) { "Identifier $identifier does not match any of the Platform values" }
            return null
        }
    }

    fun getIdentifier(): String {
        return identifier
    }
}