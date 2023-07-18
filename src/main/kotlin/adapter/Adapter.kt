package adapter

class Adapter {
    fun main() {

        cellPhone(charger(usPowerOutlet().toEUPlug()
            ).toUsbTypeC()
        )

    }

    fun cellPhone(chargeCable: UsbTypeC) {
        if (chargeCable.hasPower) {
            println("I've Got The Power!")
        } else {
            println("No power")
        }
    }

    // Power outlet exposes USPlug interface
    fun usPowerOutlet(): USPlug {
        return object : USPlug {
            override val hasPower = 1
        }
    }

    // Charger accepts EUPlug interface and exposes UsbMini  interface
    fun charger(plug: EUPlug): UsbMini {
        return object : UsbMini {
            override val hasPower=Power.valueOf(plug.hasPower)
        }
    }


    fun USPlug.toEUPlug(): EUPlug {
        val hasPower = if (this.hasPower == 1) "TRUE" else "FALSE"
        return object : EUPlug {
            // Transfer power
            override val hasPower = hasPower
        }
    }

    fun UsbMini.toUsbTypeC(): UsbTypeC {
        val hasPower = this.hasPower == Power.TRUE
        return object : UsbTypeC {
            override val hasPower = hasPower
        }
    }




}