package com.lumi.commons.enumerations

enum class SignType(private var identifier: String) {

    SIGN_MESSAGE("sign_message"),
    SIGN_PERSONAL_MESSAGE("sign_personal_message"),
    SIGN_TRANSACTION("sign_transaction"),
    SIGN_TYPED_MESSAGE("sign_typed_message");

    companion object {
        @JvmStatic
        fun fromIdentifier(identifier: String?): SignType? {
            if (identifier != null)
                for (value in SignType.values())
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