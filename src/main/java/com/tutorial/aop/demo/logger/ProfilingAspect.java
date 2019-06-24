package com.tutorial.aop.demo.logger;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ProfilingAspect {

    private boolean header = false;

    private static final String line =
            "+----------------------------------------------------+----------------------------------------------------+--------------+--------------+--------------+%n";
    private static final String headerFormat = "| %-50s | %-50s | %-12s | %-12s | %-12s |%n";
    private static final String contentFormat = "| %-50s | %-50s | %-12d | %-12d | %-12d |%n";

    /*
    @Pointcut("execution(* com.tutorial..aop.demo.UserController.*(..)))")
    public void loggable() {

    }


    @Before("execution(* com.tutorial..aop.demo.*.*(..))")
    public void beforeMethodStatistics( JoinPoint jp )
            throws Throwable {

        log.info( "System Time in millis before: " + Calendar.getInstance().getTimeInMillis() );

            StringBuilder sb = new StringBuilder();
            sb.append( "Execution Details: \t Method " )
                    .append( className )
                    .append( "." )
                    .append( methodName )
                    .append( " execution lasted: " )
                    .append( timeTaken / 1000f )
                    .append( " seconds" )
                    .append( "\t" ).append( "Memory Usage by: " ).append( pjp ).append( " = " ).append( memoryUsage );

            log.info( sb.toString() );
    }

    @After("execution(* com.tutorial..aop.demo.UserController.*(..))")
    public void afterMethodStatistics( JoinPoint jp ) {
        log.info( "System Time in millis after: " + Calendar.getInstance().getTimeInMillis() );
        Object[] args = jp.getArgs();
        if ( null != args && args.length > 0 ) {
            for ( Object arg : args ) {
                if ( arg instanceof BaseRequest ) {
                    StatisticsUtils.calculateStatistics( jp, arg, StatisticsMapEnum.ASPECT_LOGGER_STATISTICS_MAP );
                    break;
                }
            }
        }
    }

*/

    @Around("execution(* com.tutorial.aop.demo.service.*.*(..))")
    public Object around( ProceedingJoinPoint pjp )
            throws Throwable {
        long startTime = System.currentTimeMillis();
        long freeMemory = Runtime.getRuntime().freeMemory();
        String className = pjp.getTarget().getClass().getCanonicalName();
        String methodName = pjp.getSignature().getName();

        if ( !header ) {

            header = true;
            System.out
                    .format( line );
            System.out
                    .format( String.format( headerFormat, "CLASSNAME", "METHOD NAME", "TIME", "MEMORY USED", "MEMORY FREE" ) );
            System.out
                    .format( line );
        }
        try {
            return pjp.proceed();
        } catch ( Throwable e ) {
            throw e;
        } finally {
            long timeTaken = System.currentTimeMillis() - startTime;
            long memoryUsage = freeMemory - Runtime.getRuntime().freeMemory();
            System.out.format( String.format( contentFormat, className, methodName, timeTaken, memoryUsage, Runtime.getRuntime().freeMemory() ) );
        }
    }
}
