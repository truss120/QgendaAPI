import logging.handlers
import logging

smtp_handler = logging.handlers.SMTPHandler(mailhost=("SMTP.bcm.edu"),
                                            fromaddr="do-not-reply@bcm.edu",
                                            toaddrs=["abed@bcm.edu"],
                                            subject="Unhandled Exception")


logger = logging.getLogger()
logger.addHandler(smtp_handler)

